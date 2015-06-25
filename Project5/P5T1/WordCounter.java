
import java.io.IOException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

/**
 * This class contains main method that will count number of words in given
 * input file.
 *
 * @author mkarinya
 */
public class WordCounter {

    /**
     * The main method will call mapper and reducer to count number of words in
     * given input file
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: WordCounter <input path> <output path>");
            System.exit(-1);
        }
        JobConf conf = new JobConf(WordCounter.class);
        conf.setJobName("Word Counter");
        FileInputFormat.addInputPath(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));
        conf.setMapperClass(WordCounterMapper.class);
        conf.setReducerClass(WordCounterReducer.class);
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);
        JobClient.runJob(conf);
    }
}