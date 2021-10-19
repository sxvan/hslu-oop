public abstract class CountingSwitchable implements Switchable {
    private long switchCount;
    
    protected CountingSwitchable() {
        this.switchCount = 0;
    }
    
    public void switchOn() {
        this.switchCount++;
    }
    
    public void switchOff() {
        this.switchCount++;
    }
    
    public long getSwitchCount() {
        return this.switchCount;
    }
}