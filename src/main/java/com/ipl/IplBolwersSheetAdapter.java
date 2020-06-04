package com.ipl;

import java.util.Map;

public class IplBolwersSheetAdapter implements CricketLeagueAdapter {

    @Override
    public <E> Map loadIplSheetData( Class<E> csvClass,String ... csvFilePath) throws CricketLeagueAnalyserException {
        return CricketLeagueAdapter.super.loadIplCricketSheetData(csvFilePath[0], IplBowlersSheetCSV.class);
    }

}
