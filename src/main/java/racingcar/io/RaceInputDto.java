package racingcar.io;

public class RaceInputDto {

    private String participantsInput;
    private String attemptCountInput;

    public RaceInputDto(String participantsInput, String attemptCountInput) {
        this.participantsInput = participantsInput;
        this.attemptCountInput = attemptCountInput;
    }

    public String getParticipantsInput() {
        return participantsInput;
    }

    public String getAttemptCountInput() {
        return attemptCountInput;
    }
}
