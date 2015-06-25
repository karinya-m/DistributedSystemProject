
import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

/**
 * The ConsVowelCtr contains main method that will count number of words that
 * begin will vowels and consonants.
 *
 * @author mkarinya
 */
public class ConsVowelCtr {

    /**
     * The main method will call mapper and reducer to count words that begin
     * will vowel and consonant.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: ConsVowelCtr <input path> <output path>");
            System.exit(-1);
        }
        JobConf conf = new JobConf(ConsVowelCtr.class);
        conf.setJobName("ConsVowelCtr");
        FileInputFormat.addInputPath(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));
        conf.setMapperClass(ConsVowelCtrMapper.class);
        conf.setReducerClass(ConsVowelCtrReducer.class);
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);
        JobClient.runJob(conf);
    }
}