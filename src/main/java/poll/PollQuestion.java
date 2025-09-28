package poll;

import java.util.ArrayList;
import java.util.List;

public class PollQuestion {
    private final String title;
    private final int minAnswer;
    private final int maxAnswer;
    private final List<String> answers;

    private PollQuestion(
            String title,
            int minAnswer,
            int maxAnswer,
            List<String> answers
    ) {
        this.title = title;
        this.minAnswer = minAnswer;
        this.maxAnswer = maxAnswer;
        this.answers = answers != null ? answers : new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public int getMinAnswer() {
        return minAnswer;
    }

    public int getMaxAnswer() {
        return maxAnswer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public static class PollQuestionBuilder {
        private final Poll.PollBuilder pollBuilder;
        private String title;
        private int minAnswer;
        private int maxAnswer;
        private List<String> answers;

        PollQuestionBuilder(Poll.PollBuilder pollBuilder, String title) {
            this.pollBuilder = pollBuilder;
            this.title = title;
            this.answers = new ArrayList<>();
        }

        public PollQuestionBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public PollQuestionBuilder withMinAnswers(int minAnswers) {
            this.minAnswer = minAnswers;
            return this;
        }

        public PollQuestionBuilder withMaxAnswers(int maxAnswers) {
            this.maxAnswer = maxAnswers;
            return this;
        }

        public PollQuestionBuilder withAnswerVariant(String answerVariant) {
            this.answers.add(answerVariant.trim());
            return this;
        }

        public Poll.PollBuilder and() {
            PollQuestion pollQuestion = new PollQuestion(title, minAnswer, maxAnswer, answers);
            pollBuilder.addPullQuestion(pollQuestion);
            return pollBuilder;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Тип вопроса: %s\n Варианты ответа: %s", title, answers
        );
    }
}

