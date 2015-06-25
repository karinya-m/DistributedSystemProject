
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
 * The ConsVewelCtrMapper extends MapReduceBase class. It will read word from
 * input file and put in key value pairs.
 *
 * @author mkarinya
 */
public class ConsVowelCtrMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    /**
     * The map method reads words and put in key value pairs.
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
        StringTokenizer tokenizer = new StringTokenizer(line);
        //iterate through each word and put in vowel or consonant pair.
        while (tokenizer.hasMoreTokens()) {
            String inputWord = tokenizer.nextToken();
            switch (inputWord.toLowerCase().charAt(0)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    word.set("Vowel");
                    break;
                default:
                    word.set("Consonant");
            }
            output.collect(word, one);
        }
    }
}
