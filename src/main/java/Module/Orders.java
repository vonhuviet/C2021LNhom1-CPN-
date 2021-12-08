/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module;

/**
 *
 * @author Bun
 */
public class Orders {
    int IdOrders;
    String NameProduct;
    Status status;
    Users users;
    Service service;
    String NameCustomer,AddressCustomer,MobileCustomer;
    Warehouse warehouse;
    float Weight;
    int DeliveryFee;
    float Height,Wide,Length;
    int TotalPrice;
    String Note;
    Shopinfo shopinfo;
    String RollNo;

    public Orders() {
    }

    public Orders(int IdOrders, String NameProduct, Status status, Users users, Service service, String NameCustomer, String AddressCustomer, String MobileCustomer, Warehouse warehouse, float Weight, int DeliveryFee, float Height, float Wide, float Length, int TotalPrice, String Note, Shopinfo shopinfo) {
        this.IdOrders = IdOrders;
        this.NameProduct = NameProduct;
        this.status = status;
        this.users = users;
        this.service = service;
        this.NameCustomer = NameCustomer;
        this.AddressCustomer = AddressCustomer;
        this.MobileCustomer = MobileCustomer;
        this.warehouse = warehouse;
        this.Weight = Weight;
        this.DeliveryFee = DeliveryFee;
        this.Height = Height;
        this.Wide = Wide;
        this.Length = Length;
        this.TotalPrice = TotalPrice;
        this.Note = Note;
        this.shopinfo = shopinfo;
    }

    public Orders(String NameProduct, Status status, Users users, Service service, String NameCustomer, String AddressCustomer, String MobileCustomer, Warehouse warehouse, float Weight, int DeliveryFee, float Height, float Wide, float Length, int TotalPrice, String Note, Shopinfo shopinfo) {
        this.NameProduct = NameProduct;
        this.status = status;
        this.users = users;
        this.service = service;
        this.NameCustomer = NameCustomer;
        this.AddressCustomer = AddressCustomer;
        this.MobileCustomer = MobileCustomer;
        this.warehouse = warehouse;
        this.Weight = Weight;
        this.DeliveryFee = DeliveryFee;
        this.Height = Height;
        this.Wide = Wide;
        this.Length = Length;
        this.TotalPrice = TotalPrice;
        this.Note = Note;
        this.shopinfo = shopinfo;
    }

    public Orders(int IdOrders,String RollNo ,String NameProduct, String NameCustomer, String AddressCustomer, String MobileCustomer, float Weight, int TotalPrice, String Note) {
        this.IdOrders = IdOrders;
        this.RollNo = RollNo;
        this.NameProduct = NameProduct;
        this.NameCustomer = NameCustomer;
        this.AddressCustomer = AddressCustomer;
        this.MobileCustomer = MobileCustomer;
        this.Weight = Weight;
        this.TotalPrice = TotalPrice;
        this.Note = Note;
    }

    public Orders(int IdOrders, String RollNo) {
        this.IdOrders = IdOrders;
        this.RollNo = RollNo;
    }
    
    

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String RollNo) {
        this.RollNo = RollNo;
    }

    public Orders(String NameProduct, Status status, Users users, Service service, String NameCustomer, String AddressCustomer, String MobileCustomer, Warehouse warehouse, float Weight, int DeliveryFee, float Height, float Wide, float Length, int TotalPrice, String Note, Shopinfo shopinfo, String RollNo) {
        this.NameProduct = NameProduct;
        this.status = status;
        this.users = users;
        this.service = service;
        this.NameCustomer = NameCustomer;
        this.AddressCustomer = AddressCustomer;
        this.MobileCustomer = MobileCustomer;
        this.warehouse = warehouse;
        this.Weight = Weight;
        this.DeliveryFee = DeliveryFee;
        this.Height = Height;
        this.Wide = Wide;
        this.Length = Length;
        this.TotalPrice = TotalPrice;
        this.Note = Note;
        this.shopinfo = shopinfo;
        this.RollNo = RollNo;
    }
    
    

    
    
    
    
    
    public int getIdOrders() {
        return IdOrders;
    }

    public void setIdOrders(int IdOrders) {
        this.IdOrders = IdOrders;
    }

    public String getNameProduct() {
        return NameProduct;
    }

    public void setNameProduct(String NameProduct) {
        this.NameProduct = NameProduct;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getNameCustomer() {
        return NameCustomer;
    }

    public void setNameCustomer(String NameCustomer) {
        this.NameCustomer = NameCustomer;
    }

    public String getAddressCustomer() {
        return AddressCustomer;
    }

    public void setAddressCustomer(String AddressCustomer) {
        this.AddressCustomer = AddressCustomer;
    }

    public String getMobileCustomer() {
        return MobileCustomer;
    }

    public void setMobileCustomer(String MobileCustomer) {
        this.MobileCustomer = MobileCustomer;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float Weight) {
        this.Weight = Weight;
    }

    public int getDeliveryFee() {
        return DeliveryFee;
    }

    public void setDeliveryFee(int DeliveryFee) {
        this.DeliveryFee = DeliveryFee;
    }

    public float getHeight() {
        return Height;
    }

    public void setHeight(float Height) {
        this.Height = Height;
    }

    public float getWide() {
        return Wide;
    }

    public void setWide(float Wide) {
        this.Wide = Wide;
    }

    public float getLength() {
        return Length;
    }

    public void setLength(float Length) {
        this.Length = Length;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public Shopinfo getShopinfo() {
        return shopinfo;
    }

    public void setShopinfo(Shopinfo shopinfo) {
        this.shopinfo = shopinfo;
    }
    
    public void tongtien(float wei){
        
    }
}
