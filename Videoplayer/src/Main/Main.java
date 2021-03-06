package Main;


    import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

    public class Main {
//link to tutorial is http://www.capricasoftware.co.uk/projects/vlcj/tutorial1.html
//requires vlc

        private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

        public static void main(final String[] args) {
        	NativeLibrary.addSearchPath(
        	        RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC"
        	    );
        	    Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Main("C:\\<inset path here>\\Rain.avi");
                }
            });
        }

        private Main(String args) {
            JFrame frame = new JFrame("vlcj Tutorial");

            mediaPlayerComponent = new EmbeddedMediaPlayerComponent();

            frame.setContentPane(mediaPlayerComponent);

            frame.setLocation(100, 100);
            frame.setSize(1050, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            mediaPlayerComponent.getMediaPlayer().playMedia(args);
        }
    }