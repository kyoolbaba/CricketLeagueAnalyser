package com.ipl;

import java.util.Map;

public class IplBolwersSheetCSVAdapter implements CricketLeagueAdapter {

    @Override
    public <E> Map loadIplSheetData( Class<E> csvClass,String ... csvFilePath) throws CricketLeagueAnalyserException {
        return CricketLeagueAdapter.super.loadIplCricketSheetData(csvFilePath[0],Ipl2019BowlersSheetCSV.class);
    }

}