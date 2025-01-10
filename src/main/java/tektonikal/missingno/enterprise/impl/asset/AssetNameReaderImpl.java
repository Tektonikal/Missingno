package tektonikal.missingno.enterprise.impl.asset;

import tektonikal.missingno.enterprise.Constants;
import tektonikal.missingno.enterprise.pub.asset.AssetNameSupplier;

public class AssetNameReaderImpl implements AssetNameSupplier {

    @Override
    public String retrieveAssetName() {
        return Constants.assetName;
    }

}
