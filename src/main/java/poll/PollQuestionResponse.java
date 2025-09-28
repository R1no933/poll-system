package poll;

import java.util.List;

public class PollQuestionResponse {
    private final PollQuestion pollQuestion;
    private final List<String> selectedVariants;

    public PollQuestionResponse(
            PollQuestion pollQuestion,
            List<String> selectedVariants
    ) {
        this.pollQuestion = pollQuestion;
        this.selectedVariants = selectedVariants;
    }

    public PollQuestion getPollQuestion() {
        return pollQuestion;
    }

    public List<String> getSelectedVariants() {
        return selectedVariants;
    }
}
