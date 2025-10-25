package racingcar.domain;

import racingcar.io.RaceInputDto;

public class InformationDesk {

    private final Inspector inspector = new Inspector();

    public Race register(RaceInputDto raceInputDto) {
        inspector.check(raceInputDto);
        Participants participants = Participants.from(raceInputDto.getParticipantsInput());
        return null;
    }
}
