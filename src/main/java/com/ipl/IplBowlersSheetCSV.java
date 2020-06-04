package com.ipl;

import com.opencsv.bean.CsvBindByName;

public class IplBowlersSheetCSV {

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Ov")
    public double overs;

    @CsvBindByName(column = "Runs")
    public int runs;

    @CsvBindByName(column = "Wkts")
    public int wickets;

    @CsvBindByName(column = "Avg")
    public double bowlingAverage;

    @CsvBindByName(column = "Econ")
    public double economy;

    @CsvBindByName(column = "SR")
    public double strikeRate;

    @CsvBindByName(column = "5w")
    public int fiveWickets;

    @CsvBindByName(column = "4w")
    public int fourWickets;

    public IplBowlersSheetCSV() {
    }

    public IplBowlersSheetCSV(String player,
                              double overs,
                              int runs, int wickets,
                              double average, double economy,
                              double strikeRate, int fiveWickets,
                              int fourWickets) {
        this.player = player;
        this.overs = overs;
        this.runs = runs;
        this.wickets = wickets;
        this.bowlingAverage = average;
        this.economy = economy;
        this.strikeRate = strikeRate;
        this.fiveWickets = fiveWickets;
        this.fourWickets = fourWickets;
    }

    @Override
    public String toString() {
        return "Ipl2019WicketsSheetCSV{" +
                "player='" + player + '\'' +
                ", overs=" + overs +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", average=" + bowlingAverage +
                ", economy=" + economy +
                ", strikeRate=" + strikeRate +
                ", fiveWickets=" + fiveWickets +
                ", fourWickets=" + fourWickets +
                '}';
    }
}