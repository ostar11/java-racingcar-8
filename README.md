# java-racingcar-precourse

## 기능 구현 목록

---
### 1. RaceApplication
- 사용자 입력, 경기 진행, 결과 출력의 전체 흐름 관리
### 2. InputReader
- 자동차 이름 입력
- 시도 횟수 입력 입력
### 3. Inspector
- 자동차 이름이 비어있는지 검증
- 시도 횟수가 비어있는지 검증
### 4. InformationDesk / ReceptionDesk
- 자동차 이름을 기반으로 참가자 생성
- 참가자 등록
### 5. Participant
- 이동
### 6. Participants
- 참가자 목록 관리
### 7. Race
- 횟수만큼 경주 진행
- 참가자에게 이동 요청
- 차수별 결과 추출
### 8. Referee
- 차수별 결과 기록
- 경기가 종료되면 우승자 판정
### 9. OutputWriter
- 차수별 이동 결과 출력
- 우승자 출력
### 10. Participants
- 자동차 이름 중복 여부 검증
### 11. Car
- 자동차 이름 유효성 검증
### 12. RaceRule
- 시도 횟수가 숫자인지 검증
- 시도 횟수가 양수인지 검증
