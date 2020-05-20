package com.ipl;

import com.IndianCensus.CSVBuilderException;
import com.IndianCensus.CSVBuilderFactory;
import com.IndianCensus.ICSVBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class IplBolwersSheetCSVAdapter extends CricketLeagueAdapter {

    @Override
    public <E> Map loadIplSheetData( Class<E> csvClass,String ... csvFilePath) throws CricketLeagueAnalyserException {
        return super.loadIplCricketSheetData(csvFilePath[0],Ipl2019BowlersSheetCSV.class);
    }

}
