# java-racingcar-precourse

## 기능 구현 목록

---
### 전체 흐름 관리
- `RaceApplication` : 사용자 입력, 경기 진행, 결과 출력의 전체 흐름 관리
- `ApplicationConfiguration` : 의존성 주입
---
### 도메인

##### InformationDesk
- 자동차 이름을 기반으로 참가자 생성
- 참가자 등록

##### Inspector
- 자동차 이름이 비어있는지 검증
- 자동차 이름 형식이 적합한지 검증
- 시도 횟수가 비어있는지 검증

##### ParticipantFactory
- `ParticipantParser` : 참가자 문자열 분해
- `ParticipantValidator`: 참가자 중복 검증

##### RuleFactory
- `RuleParser` : 규칙 문자열 분해
- `RuleValidator`: 규칙 시도 횟수 검증

##### Participants
- 참가자 목록 관리
- 이동 명령

##### Car
- 이동

##### Race
- 횟수만큼 경주 진행
- 참가자에게 이동 요청
- 라운드별 결과 추출

##### Referee
- 라운드별 결과 기록
- 경기가 종료되면 최종 결과('RaceResult') 반환 

##### RaceHistory
- 모든 라운드 기록 보관
- 우승자 추출

##### RaceRecord
- 라운드 기록 보관
- 라운드 승자 반환
- 라운드 최고 점수 반환

##### RaceScore
- 참가자 이름과 위치 보관
---
### 입출력 
##### InputReader
- 자동차 이름 입력
- 시도 횟수 입력 입력

##### OutputWriter
- 차수별 이동 결과 출력
- 우승자 출력
---
### Util
##### NumberGenerator
- 난수 생성기

##### RaceResultMapper
- 결과 변환