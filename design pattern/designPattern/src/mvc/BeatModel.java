package mvc;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.Sequence;
import java.util.ArrayList;

public class BeatModel implements BeatModelInterface, MetaEventListener {
    Sequence sequencer;
    ArrayList beatObservers = new ArrayList();
    ArrayList bpmObservers = new ArrayList();
    int bpm = 90;

    public void initialize(){
        setUpMidi();
        buildTrackAndStart();
    }

    public void off(){
        setBPM(0);
        sequencer.stop();
    }

    public void setBPM(int bpm){
        this.bpm = bpm;
        sequencer.setTempoInBPM(getBPM());
        notifyBPMObservers();
    }

    public int getBPM(){
        return bpm;
    }

    void beatEvent(){
        notifyBeatObservers();
    }
}
