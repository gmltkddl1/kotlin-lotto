package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.LottoNumberGenerator
import lotto.domain.LottoNumbers
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberMatcherTest {
    @Test
    fun `당첨 번호과 로또 번호들을 비교하여 번호의 일치 갯수를 구한다`() {
        val winningNumbers = WinningNumbers(LottoNumbers.of(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))
        val lottoNumberGenerator =
            LottoNumberGenerator { LottoNumbers.of(listOf(1, 2, 3, 4, 7, 8)) }
        val lottoMachine = LottoMachine(lottoNumberGenerator)
        val lottos = lottoMachine.makeLottosAuto(1)
        assertThat(lottos.lottos.map { winningNumbers.matchNumbers(it) }).containsExactly(4)
    }
}
