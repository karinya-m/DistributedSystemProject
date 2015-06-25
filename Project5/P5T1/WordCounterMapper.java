
import java.io.IOException;
import java.util.*;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

/**
 * The WordCounterMapper extends from MapReducBase and will read word from file
 * and put them in value/key pairs for counting.
 *
 * @author mkarinya
 */
public class WordCounterMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    /**
     * The map method reads words from input file and put them in value/key
     * pairs for counting.
     *
     * @param key
     * @param value
     * @param output
     * @param reporter
     * @throws IOException
     */
    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        // Get line from input file. This was passed in by Hadoop as value.
        String line = value.toString();
        word.set("Count");
        StringTokenizer tokenizer = new StringTokenizer(line);

        while (tokenizer.hasMoreTokens()) {
            //to move to to the next word token.
            String temp = tokenizer.nextToken();
            output.collect(word, one);
        }
    }
}
