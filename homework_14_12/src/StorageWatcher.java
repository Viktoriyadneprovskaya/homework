abstract class StorageWatcher{
    float normalMinTemp;
    float normalMaxTemp;
    String storageName;

    StorageWatcher(){
        this.storageName = "main storage";
        this.normalMinTemp = 1.0f;
        this.normalMaxTemp = 12.3f;
    }
        public void startCheckStorageTemperature(float currentTemp) {

    }
}

