
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

/**
 * The ConsVowelCtrReducer class extends from MapReduceBase class. It will add
 * up number of words for each key.
 *
 * @author mkarinya
 */
public class ConsVowelCtrReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {

    /**
     * The reduce method will add up number of words for consonant and vowel
     * key.
     *
     * @param key
     * @param values
     * @param output
     * @param reporter
     * @throws IOException
     */
    public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        // sum up number of word
        int sum = 0;
        while (values.hasNext()) {
            sum += values.next().get();
        }
        output.collect(key, new IntWritable(sum));
    }
}
