class Solution {
    public double angleClock(int hour, int minutes) {
        double ans=0;
        double min=0;
        double hr=0;
        min=6*minutes;
        hr=30*hour;
        hr+=0.5*minutes;
        hr=hr%360;
        return Math.min(Math.min(Math.abs(hr-min),Math.abs((360-min+hr))),Math.abs(360-hr+min));
    }
}