package Basics;

// https://github.com/yennanliu/Apache-Kafka-For-Absolute-Beginners/blob/master/08-pos-simulator-avro/src/main/java/guru/learningjournal/kafka/examples/PosSimulator.java

class GetArgsFromCli {
    public static void main(String [] args){
        if (args.length < 3){
            System.out.println("Not enough args, plz at least offer 3 args");
            System.exit(-1);
        }
        String arg_1 = args[0];
        String arg_2 = args[1];
        String arg_3 = args[2];
        System.out.println("*** args = " + arg_1 + arg_2 + arg_3);
    }
}
