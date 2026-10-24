class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int count=0;

        int[] days={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int aliceStartMonth=Integer.parseInt(arriveAlice.substring(0,2));
        int aliceStartDay=Integer.parseInt(arriveAlice.substring(3,5));

        int aliceEndMonth=Integer.parseInt(leaveAlice.substring(0,2));
        int aliceEndDay=Integer.parseInt(leaveAlice.substring(3,5));

        int bobStartMonth=Integer.parseInt(arriveBob.substring(0,2));
        int bobStartDay=Integer.parseInt(arriveBob.substring(3,5));

        int bobEndMonth=Integer.parseInt(leaveBob.substring(0,2));
        int bobEndDay=Integer.parseInt(leaveBob.substring(3,5));

        for(int month=1;month<=12;month++){
            for(int day=1;day<=days[month-1];day++){

                boolean alice=(month>aliceStartMonth ||
                (month==aliceStartMonth && day>=aliceStartDay))
                && (month<aliceEndMonth ||
                (month==aliceEndMonth && day<=aliceEndDay));

                boolean bob=(month>bobStartMonth ||
                (month==bobStartMonth && day>=bobStartDay))
                && (month<bobEndMonth ||
                (month==bobEndMonth && day<=bobEndDay));

                if(alice && bob){
                    count++;
                }
            }
        }
        return count;
    }
}