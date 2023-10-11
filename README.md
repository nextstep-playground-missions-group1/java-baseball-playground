## 애플리케이션 기능 소개
- 사용자가 난이도를 선택할 수 있고, 선택한 난이도에 따라 기회(chance)를 다르게 제공됩니다.
- 3 스트라이크를 성공시키면 '성공 메시지'가, 모든 기회를 소진하면 '실패 메시지'가 출력됩니다.
- 마지막 기회(chance)인 경우, 사용자에게 마지막 기회임을 강조하는 메시지가 출력됩니다.
- 한 도전이 끝나면 마지막에 컴퓨터 숫자를 공개하여 정답 확인이 가능합니다.
- 원하면 재도전이 가능합니다.

## 실행 모습
### 숫자 게임 실행 화면
![숫자게임 실행 화면](https://github.com/nextstep-playground-missions-group1/java-baseball-playground/assets/85631282/ee5f03dc-e862-4ff4-8696-bcb214dcd57d)

### 미션 성공 메시지 출력
![성공 메시지 출력](https://github.com/nextstep-playground-missions-group1/java-baseball-playground/assets/85631282/ec6b3d61-e7c6-4897-9b03-17fe98b327fc)

### 미션 실패 메시지 출력
![미션 실패 메시지 출력](https://github.com/nextstep-playground-missions-group1/java-baseball-playground/assets/85631282/bc1782e7-4c89-4d4b-bba3-3ba68920c7e5)

### 테스트 코드 실행
![Screen Shot 2023-10-08 at 11 34 10 PM](https://github.com/nextstep-playground-missions-group1/java-baseball-playground/assets/85631282/2a3f1ff8-6204-46a3-ab27-cf68a1735859)

## 예외 처리
### 난이도 선택 예외처리
![난이도 선택 예외처리](https://github.com/nextstep-playground-missions-group1/java-baseball-playground/assets/85631282/d2c3de52-a992-4247-a3b2-a73062555706)

### 사용자 입력값 예외처리
![사용자 입력값 예외처리](https://github.com/nextstep-playground-missions-group1/java-baseball-playground/assets/85631282/0f9b77bf-f109-44ad-b23a-cf36aa3655d3)

### 미션 재도전 여부 예외처리
![미션 재도전 여부 예외처리](https://github.com/nextstep-playground-missions-group1/java-baseball-playground/assets/85631282/89ba2d4e-8282-48b5-999d-86c34d92669b)

## 클래스 설명
### 1. `Application` 클래스
- `NumberBaseballGame` 객체를 생성 및 프로그램을 시작합니다.
### 2. `NumberBaseballGame` 클래스
- 숫자야구게임의 주요 흐름을 제어합니다.
- `Input`, `ScoreSystem` 객체를 의존합니다.
-  전체 게임을 시작하는 `gameStart()`, 게임 한 라운드를 실행하는 `playGame()`, 유저의 1 기회를 사용하는 `usesOneChane()` 메서드로 전체 흐름을 제어합니다.
### 3. `ScoreSystem` 클래스
- 점수 채점에 대한 주요 로직을 담당합니다.
- `countStrikes()`는 스트라이크 개수를 반환합니다.
- `countBalls()`는 볼 개수를 반환합니다.
- 볼 개수는 유저 숫자와 컴퓨터 숫자에 매칭된 전체 개수를 알아낸 뒤 스트라이크 개수를 빼는 방식으로 알아냅니다.
### 4. `Input` 클래스
- 유저에게 입력 값을 받는 역할을 수행합니다.
  - 난이도(Level)를 입력 받는 기능
  - 유저 번호를 입력 받는 기능
  - 재도전 여부를 입력 받는 기능
### 5. `View` 클래스
- 사용자에게 보여지는 출력 메시지를 담당합니다.
### 6. `Level` enum 클래스
- 사용자가 선택한 난이도에 대해 관리합니다.