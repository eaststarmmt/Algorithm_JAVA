package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @RestController
    public static class ApiController {
        private final String DATA_DIR = "./data/input";
        private final ObjectMapper objectMapper = new ObjectMapper();

        @GetMapping("/api/gamerecord/users")
        // 여기에 코드를 작성하세요.
        public ResponseEntity<?> getUsers() {
            try {
                List<Map<String, Object>> users = objectMapper.readValue(
                        Files.readAllBytes(Paths.get(DATA_DIR, "records.json")),
                        new TypeReference<>() {
                        });
                users.sort((m1, m2) -> {
                    String a1 = (String) m1.get("username");
                    String a2 = (String) m2.get("username");
                    String b1 = (String) m1.get("tag");
                    String b2 = (String) m2.get("tag");
                    if(a1.equals(a2)) return b1.compareTo(b2);
                    return a1.compareTo(a2);

                });
                return ResponseEntity.ok(users);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @GetMapping("/api/gamerecord/winrate")
        // 여기에 코드를 작성하세요.
        public ResponseEntity<?> getWinrate(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String tag
        ) {
            Map<String, Object> res = new HashMap<>();

            if(username == null || username.isBlank() || username.isEmpty()) {
                res.put("error", "Invalid data format");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
            }
            if(tag == null || tag.isBlank() || tag.isEmpty()) {
                res.put("error", "Invalid data format");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
            }
            try {
                List<Map<String, Object>> users = objectMapper.readValue(
                        Files.readAllBytes(Paths.get(DATA_DIR, "records.json")),
                        new TypeReference<>() {
                        });

                
  
                users.forEach(user -> {                
                    if(user.get("username").equals(username) && user.get("tag").equals(tag)) {
                        int win = (int)user.get("win");
                        int lose = (int)user.get("lose");
                        res.put("winrate", 100 * win / (win + lose));
                    }
                });
   
                if(res.isEmpty()) {
                    res.put("error", "data not found");
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
                }

                return ResponseEntity.ok(res);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
    }
}