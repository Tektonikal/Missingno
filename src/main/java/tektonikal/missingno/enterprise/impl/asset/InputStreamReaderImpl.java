package tektonikal.missingno.enterprise.impl.asset;

import tektonikal.missingno.enterprise.pub.asset.StreamReader;

import java.io.InputStream;

public class InputStreamReaderImpl implements StreamReader {

    protected volatile transient InputStream _stream;

    public InputStreamReaderImpl(InputStream stream) {
        this._stream = stream;
    }


    @Override
    public byte[] readStream() {
        try {
            return _stream.readAllBytes();
        } catch (final Exception e) {// TODO: Enterprise level project wide Exception and Throwable handling
            return new byte[0];
        }
    }

}
