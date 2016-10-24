package dz5CSVFile;

import java.util.List;

/**
 * Created by user on 18.10.16.
 */
public class ResultLottery {

    private int numOfGame;
    private String date;
    private String machine;
    private List<Integer> numbers;

    public int getNumOfGame() {
        return numOfGame;
    }

    public void setNumOfGame(int numOfGame) {
        this.numOfGame = numOfGame;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ResultLottery{");
        sb.append("numOfGame=").append(numOfGame);
        sb.append(", date=").append(date);
        sb.append(", machine='").append(machine).append('\'');
        sb.append(", numbers=").append(numbers);
        sb.append('}');
        return sb.toString();
    }
}
