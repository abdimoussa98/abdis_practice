import java.util.HashMap;
import org.apache.commons.lang3.time.StopWatch;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        //HARRY/SALLY EXPECTED = 2
        //THE LONG ONE EXPECTED = 321
        StopWatch watch = new StopWatch();
        //String s3 = "HARRY";
        String s1 = "LZNGFTIHZHJSQGQQYICYKYAPAFJMYXIRFHFISJZJAVHMQLPBFXSPEEQAUJIIVSVLCRVHSMIGXQIVOOAFHIQOAOJBOTGJUPXEPQZFJSNLVDHCXMDRPPGTUNBIMARYQXUTMQVGOVZDYSCBCHRTTAYEIFFNAGFDFGEFJNAXKWUYNFPETFYTHRLEICJEFDFHJFADZFBRABLMDYNGIBXHGWDOWIFLWUKFVFUIITQGFRCGUYFZINJYIGXCKNPVDPMUKTVOIBSIUUDQDWXTJAIGVSFROIGSEOWNZAWDRIZFLFQAYQKETDOYLUOHSVUYOJLDCJNIWDOFBRLWXQSCCTDEQHGHUXCHTCFSZRTRESSXNVOXFAHSWUAVJXMHCKRCOYVENGGBSXXYPEPUAQFNNCRVFQQDFCBPNTTNISDVORWBJBBCVVNLYUTTSBPRXSKYFEKOMIZCGNSQHZYVCHHILQLGCLIKTNCLQUOUAXFNHJPIZYBYWSVMGUVAGXANTEZHSDUDBVVCAGCPKJAQXIOQOCTNNOOFUYZEGGPAEQGRRDREZUSVTKCQAZQDZAEIIGOCJPMQXRHRFQTCBNEMSAPSSLHXJVDBCSGQVUPGNCZKTFEBRIKWKSYXWRAHGNGYLLXFKJOUNXKDRWMBVOZGEOBAYYNFDNHHWFVPOKWUFLZTZUCMLGFVUWFXSVYYUBGRHAUWHBQSNIHENTXADZCCZZZPOPESVYCROMUBJPDGBGUHBSMUQSYGEHUCRDACDYJIPYBLPXQUOLSELHBBBYQHKIOVFMSXANOMKMOXNPTGZSVHMCAEFSCNMCPHFUHOMNRNEQBOSLMAHJAMSMQMGKTLVKBVTSUDDWKXHHIIAFVNMQIHVVEPACCEVVECWOBVZVTWWMDIKYZAGZJOLQCINZZVZFNJGTCXXVLRAGJQFDMYMNKQDWNCLRTPYCCXEQFGKQWQSSYXNGELLNMAKNPIKFNKUIDCRUTWSTRKIHUAOGMPXOBQTFFAQMKG";
        int i = s1.length() - 1;
        //String s4 = "SALLY";
        String s2 = "BLCRCQQMXZCBACBDSFGIQDKFFHGPOGSZLHLXNZSSXRGVKIGNABASNFZDHVJOAINPZEZNDWOWSEJGMOVPPXHBERDJXLJSPAQDKNQEJMTBMVTPRXOCHYPKMDGRIHUPBQWZBNIXJBPTFYRMIUNXLVKPIRLLGJVGBIBIGDRIWGKEIKKYGCCFHCTEVNJPWFCFPDOXQDYGHRRNXTFQRGCTITBUEPHPEIXQMYSKLYQXZWVRWDBYLJRBOWRAHRWUJWZKEGBCEHVTKJERFIJVWWVSRVNIDHYVEYIWAPHYSIKCBDBDWXAWXEHRFMHCQNHTBYOFYJBIKJGUDIMQKNFCKMWNGVROISVLPZZCRUKHBWPSHRBSERBQOJXFTKSDDCRBIACQMHIOQBNESXTNURRXONVMNGZBMBDZDBWGXMFNCJWVUICKVQHUDDMVHNHRAHRDHOITKDDRRMFSQFZSLAASQSKJTVWTOSWQSPEARPEWADMMNSPCZTMKGVQOBGOBMGICUZNBEBZBFDRPFJPLCJOUTZBNJAKTTMQPQVQOGVHIBNWFXOQWSMUSCBBCZURZOYRHSTKIFUXWROLBQBLYEDXQHKXYZNWVDCRAABKUBAPCPLKPZRQWNSWRCLNGDYLICBQAPPFNIDNCRMZEJJNNSUDDMAAOJPDQZPBRYKMVACVMTNNPQZBWHYALBHLDAYTJGJOWXQYVQQVNHLJXVVEXIPHEZZCKLKXNKLAYSHPSWWBPOQXZJYNFWBYVMMTMKFWJVPGHTGXCMBKTBWIXQJAMGVNRALOCACXIICCVEWKKSFDBMPRJUEYCHROEDXTKYJYSGVITYMVSAAEVKDAEDXWDBSHFTXDCDRTLCCFAKWSBNTPUSXIGTSXOVPIMVURDXOGBOOQAHISZBKADCRXVSJSICXWQNMQGCCPTHWHKFKDXUGARNLREDXZIROXZTXPAVOGORNCVXGAMFVJUKLGPHSZKVVMRMFXLYUZNDUYOIIHJCKDWQXNCIYNG";
        int j = s2.length() - 1;
        HashMap<String, Integer> memo = new HashMap<>();

        watch.start(); // start watch for slow algo
        //System.out.println(LCSBrute(s1,s2,i,j));
        watch.stop();
        System.out.println("Time Elapsed for SLOW algo: " + watch.toString());

        watch.reset();
        watch.start(); // start watch for fast algo
        System.out.println(LCS(s1,s2,i,j,memo));
        watch.stop();
        System.out.println("Time Elapsed for FAST algo: " + watch.toString());

    }

    static int LCSBrute(String s1, String s2, int i, int j){

        if (i == -1 || j == -1) { //base case that s1 or s2 has reached the beginning of string
            return 0;
        }
        if (s1.charAt(i) == s2.charAt(j)){ //we found a match
            return 1 + LCSBrute(s1, s2, i - 1, j - 1); //return 1 for increment num of subsequence, then recursively call LCS and decrement i and j to look at next letter to the left
        }
        return Math.max(LCSBrute(s1, s2, i - 1, j), LCSBrute(s1, s2, i, j - 1));
    }

    static int LCS(String s1, String s2, int i, int j, HashMap<String, Integer> memo){
        /*
        * this needs to be reevaluated since im making to many recursive calls when 'unwinding' the call stack
        *   I already have calculated the value, so I don't need to start winding again once at the last return statement.
        */
        String pos = i + "," + j;
        if (i == -1 || j == -1) { //base case that s1 or s2 has reached the beginning of string
            return 0;
        }
        if (memo.containsKey(pos)){
            return memo.get(pos);
        }
        if (s1.charAt(i) == s2.charAt(j)){ //we found a match
            memo.put(pos, 1 + LCS(s1, s2, i - 1, j - 1, memo));
            return 1 + LCS(s1, s2, i - 1, j - 1, memo); //return 1 for increment num of subsequence, then recursively call LCS and decrement i and j to look at next letter to the left
        }
        memo.put(pos, Math.max(LCS(s1, s2, i - 1, j, memo), LCS(s1, s2, i, j - 1, memo)));
        return Math.max(LCS(s1, s2, i - 1, j, memo), LCS(s1, s2, i, j - 1, memo));
    }
}
