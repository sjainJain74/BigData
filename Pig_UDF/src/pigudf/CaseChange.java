package pigudf;

import java.io.IOException;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

public class CaseChange extends EvalFunc<String> {
	public String exec(Tuple input) throws IOException {
		try {
			return ((String)input.get(0)).toUpperCase();
		}
		catch (Exception e) {
			throw new IOException(e);
		}
	}	
}