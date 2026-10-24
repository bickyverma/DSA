class Solution {
    private static final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int Astart = days(arriveAlice);
        int Aleave = days(leaveAlice);
        int Bstart = days(arriveBob);
        int Bleave = days(leaveBob);

        int common = Math.max(Astart, Bstart);
        int end = Math.min(Aleave, Bleave);

        return Math.max(0, end-common+1);
    }

    public int days(String date){
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int total = day;
        for(int i = 0; i < month-1; i++){
            total += DAYS_IN_MONTHS[i];
        }
        return total;
    }
}