package datatypes;

public class Address {
    private String _streetAddress, _city, _state, _zipcode, _country;

    public Address() {
    }

    public Address(String _streetAddress, String _city, String _state, String _zipcode, String _country) {
        this._streetAddress = _streetAddress;
        this._city = _city;
        this._state = _state;
        this._zipcode = _zipcode;
        this._country = _country;
    }

    public String get_streetAddress() {
        return _streetAddress;
    }

    public void set_streetAddress(String _streetAddress) {
        this._streetAddress = _streetAddress;
    }

    public String get_city() {
        return _city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }

    public String get_state() {
        return _state;
    }

    public void set_state(String _state) {
        this._state = _state;
    }

    public String get_zipcode() {
        return _zipcode;
    }

    public void set_zipcode(String _zipcode) {
        this._zipcode = _zipcode;
    }

    public String get_country() {
        return _country;
    }

    public void set_country(String _country) {
        this._country = _country;
    }
}
