package by.artkostm.androidparsers.core.reader.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.artkostm.androidparsers.core.reader.CSVTokenizer;
import by.artkostm.androidparsers.core.util.CSVStrategy;
import by.artkostm.androidparsers.core.util.CSVUtil;

/**
 * A very simple csv tokenizer implementation.
 * If you do not need field quotations or multi line columns, this
 * will serve your purposes.
 *
 */
public class SimpleCSVTokenizer implements CSVTokenizer {

	/**
	 * Performs a split() on the input string. Uses the delimiter specified in the csv strategy.
	 *
	 */
	@Override
	public List<String> tokenizeLine(String line, CSVStrategy strategy, BufferedReader reader) throws IOException {
		if (line.equals("")) {
			return new ArrayList<String>();
		}

		// split the line and preserve all tokens
		List<String> tokens = Arrays.asList(CSVUtil.split(line, strategy.getDelimiter(), true));

		return tokens;
	}
}
