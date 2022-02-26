### jn-java-lotto
우아한 테크 pro 스터디를 위한 프로젝트

## 3단계 - 로또(자동)

### 기능 목록

- [x] 로또 개수를 위한 Money
  - [x] 로또 한장에 1000원 이므로 나눠서 로또 개수 구하는 기능
  - [x] 음수가 아닌지 확인하는 기능
  - [x] 1000원 단위인지 확인하는 기능
- [x] Lotto
  - [x] 로또 번호가 6개인지 확인하는 기능
- [x] Lottos
  - [x] 여러개의 Lotto를 통해 Lottos 생성 기능
- [x] TotalLottoNumbers
  - [x] 1 ~ 45를 포함한 객체 생성 기능
  - [x] shuffle(), sort()후 6자리 로또 번호 생성 기능
- [x] WinningNumbers
  - [x] 당첨 번호를 Lotto 객체로 바꾸는 기능
- [x] LottoPrize
  - [x] 당첨 개수에 따른 상금 enum 생성
- [x] LottoResult
  - [x] Map에 0 ~ 6 까지 값 넣어놓는 init 기능
  - [x] Lottos, winningLotto 번호 비교후 몇개 맞았는지 체크하는 기능
  - [x] 로또 수익률 계산 기능
- [x] Input 기능
- [x] Output 기능
