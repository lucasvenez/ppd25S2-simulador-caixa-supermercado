import java.security.InvalidParameterException;
import java.util.Random;

public class SimulacaoCaixaSupermercado {

    private final Random random = new Random();

    private final double TEMPO_ATENDIMENTO_MINIMO = 1.00;

    private int numeroCaixas;

    private double mediaTempoAtendimento;
    private double desvioTempoAtendimento;

    public void setNumeroCaixas(int numeroCaixas) {

        if (numeroCaixas < 1)
            throw new InvalidParameterException("Número de caixas deve ser maior que zero!");

        this.numeroCaixas = numeroCaixas;
    }

    public void setMediaTempoAtendimento(double mediaTempoAtendimento) {
        this.mediaTempoAtendimento = mediaTempoAtendimento;
    }

    public void setDesvioTempoAtendimento(double desvioTempoAtendimento) {
        this.desvioTempoAtendimento = desvioTempoAtendimento;
    }

    private double simularTempoAtendimento() {

        double desvioSimulado = this.random.nextGaussian();

        double tempoAtendimentoSimulado = this.mediaTempoAtendimento +
            this.desvioTempoAtendimento * desvioSimulado;

        return tempoAtendimentoSimulado < TEMPO_ATENDIMENTO_MINIMO ? TEMPO_ATENDIMENTO_MINIMO : tempoAtendimentoSimulado;
    }

    public double simularTempoTotalAtendimentos(int numeroAtendimentos) {
        
        if (numeroAtendimentos < 1)
            throw new InvalidParameterException("numeroAtendimentos deve ser maior que zero!");

        double[] caixas = new double[this.numeroCaixas];

        for (int i = 0; i < this.numeroCaixas; i++)
            caixas[i] = 0.0;

        for (int atendimento = 0; atendimento < numeroAtendimentos; atendimento++)
            caixas[atendimento % this.numeroCaixas] += this.simularTempoAtendimento();

        double maiorTempo = -1000.00;

        for (double t : caixas) {
            System.out.print("* ");
            System.out.println(t);
            if (t > maiorTempo)
                maiorTempo = t;
        }
        
        return maiorTempo;
    }

    public static void main(String[] args) {
        SimulacaoCaixaSupermercado simulador = new SimulacaoCaixaSupermercado();

        simulador.setNumeroCaixas(2);
        simulador.setMediaTempoAtendimento(5);
        simulador.setDesvioTempoAtendimento(2);
        double tempoTotalAtendimentoSimulado = simulador.simularTempoTotalAtendimentos(50);

        System.out.println(tempoTotalAtendimentoSimulado);
    }

}