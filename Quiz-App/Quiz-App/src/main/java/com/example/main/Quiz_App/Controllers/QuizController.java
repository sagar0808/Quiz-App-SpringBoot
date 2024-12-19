package com.example.main.Quiz_App.Controllers;

import com.example.main.Quiz_App.Services.QuizService;
import com.example.main.Quiz_App.models.AnswerSubmission;
import com.example.main.Quiz_App.models.Question;
import com.example.main.Quiz_App.models.QuestionResponseDTO;
import com.example.main.Quiz_App.models.QuizSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping("/")
    public String welcome(){
        return "Welcome to Quiz Application";
    }

    @PostMapping("/start")
    public ResponseEntity<QuizSession> startNewSession(@RequestParam String userId) {
        QuizSession session = quizService.startNewSession(userId);
        return ResponseEntity.ok(session);
    }

    @GetMapping("/question")
    public ResponseEntity<QuestionResponseDTO> getRandomQuestion() {
        QuestionResponseDTO question = quizService.getRandomQuestion();
        return ResponseEntity.ok(question);
    }


    @PostMapping("/submit")
    public ResponseEntity<QuizSession> submitAnswer(
            @RequestParam String userId,
            @RequestBody AnswerSubmission submission) {
        QuizSession session = quizService.submitAnswer(userId, submission);
        return ResponseEntity.ok(session);
    }

    @GetMapping("/session")
    public ResponseEntity<QuizSession> getQuizSession(@RequestParam String userId) {
        QuizSession session = quizService.getQuizSession(userId);
        return ResponseEntity.ok(session);
    }
}

