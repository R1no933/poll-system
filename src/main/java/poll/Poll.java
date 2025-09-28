package poll;

import java.util.ArrayList;
import java.util.List;

public class Poll {
    private final String pollName;
    private final List<PollQuestion> pollQuestionList;

    private Poll(String pollName, List<PollQuestion> pollQuestionList) {
        this.pollName = pollName;
        this.pollQuestionList = pollQuestionList != null ? new ArrayList<>(pollQuestionList) : new ArrayList<>();
    }

    public static PollBuilder builder() {
        return new PollBuilder();
    }

    public String getPollName() {
        return pollName;
    }

    public List<PollQuestion> getPollQuestionList() {
        return pollQuestionList;
    }

    public static class PollBuilder {
        private String pollName;
        private List<PollQuestion> pollQuestionList;

        private PollBuilder() {
            this.pollQuestionList = new ArrayList<>();
        }

        public PollBuilder withPollName(String pollName) {
            this.pollName = pollName;
            return this;
        }

        public PollQuestion.PollQuestionBuilder pollQuestion(String title) {
            return new PollQuestion.PollQuestionBuilder(this, title);
        }

        public PollQuestion.PollQuestionBuilder oneVariantPollQuestion(String title) {
            return new PollQuestion.PollQuestionBuilder(this, title)
                    .withMinAnswers(1)
                    .withMaxAnswers(1);
        }

        public PollBuilder yesNoPollQuestion(String title) {
            PollQuestion.PollQuestionBuilder pollQuestionBuilder = new PollQuestion.PollQuestionBuilder(this, title)
                    .withMinAnswers(1)
                    .withMaxAnswers(1)
                    .withAnswerVariant("YES")
                    .withAnswerVariant("NO");
            return pollQuestionBuilder.and();
        }

        public Poll build() {
            return new Poll(pollName, pollQuestionList);
        }

        void addPullQuestion(PollQuestion pollQuestion) {
            this.pollQuestionList.add(pollQuestion);
        }
    }

    @Override
    public String toString() {
        return String.format("Опрос: ", pollName);
    }
}

