package tektonikal.missingno.enterprise.pub.asset;

public interface AssetsPictureReader {

    void pushPictureFromAssets(final AssetNameSupplier nameSupplier);

    byte[] getPictureFromAsset();

}
