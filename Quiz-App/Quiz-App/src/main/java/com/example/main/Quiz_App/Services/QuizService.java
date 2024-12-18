package com.example.main.Quiz_App.Services;

import com.example.main.Quiz_App.Repo.QuestionRepository;
import com.example.main.Quiz_App.Repo.QuizSessionRepository;
import com.example.main.Quiz_App.models.AnswerSubmission;
import com.example.main.Quiz_App.models.Question;
import com.example.main.Quiz_App.models.QuestionResponseDTO;
import com.example.main.Quiz_App.models.QuizSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    public QuizSession startNewSession(String userId) {
        QuizSession session = new QuizSession();
        session.setUserId(userId);
        session.setTotalQuestions(0);
        session.setCorrectAnswers(0);
        session.setIncorrectAnswers(0);
        return quizSessionRepository.save(session);
    }

    public QuestionResponseDTO getRandomQuestion() {
        Question question = questionRepository.getRandomQuestion();

        return new QuestionResponseDTO(
                question.getId(),
                question.getQuestionText(),
                question.getOptionA(),
                question.getOptionB(),
                question.getOptionC(),
                question.getOptionD()
        );
    }

    public QuizSession submitAnswer(String userId, AnswerSubmission submission) {

        QuizSession session = quizSessionRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Session not found for user: " + userId));

        Question question = questionRepository.findById(submission.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        session.setTotalQuestions(session.getTotalQuestions() + 1);

        if (question.getCorrectAnswer().equalsIgnoreCase(submission.getSelectedAnswer())) {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
        } else {
            session.setIncorrectAnswers(session.getIncorrectAnswers() + 1);
        }

        return quizSessionRepository.save(session);
    }

    public QuizSession getQuizSession(String userId) {
        return quizSessionRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Session not found for user: " + userId));
    }
}

