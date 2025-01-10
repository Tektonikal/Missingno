package tektonikal.missingno.enterprise.impl.asset;

import tektonikal.missingno.enterprise.pub.asset.AssetNameSupplier;
import tektonikal.missingno.enterprise.pub.asset.AssetsPictureReader;

public class AssetsPictureReaderImpl implements AssetsPictureReader {

    protected transient volatile byte[] _currentBytes;

    @Override
    public void pushPictureFromAssets(final AssetNameSupplier nameSupplier) {
        _currentBytes = new GenericInputStreamReader()
                .getGenericStreamReader(
                        AssetsPictureReaderImpl.class
                        .getClassLoader().getResourceAsStream(
                                nameSupplier.retrieveAssetName()
                                ))
                .readStream();
    }

    @Override
    public byte[] getPictureFromAsset() {
        byte[] picture = _currentBytes;
        _currentBytes = null;
        return picture;
    }
}
