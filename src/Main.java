import constants.PaymentMode;
import controller.BuyerController;
import controller.OrderController;
import controller.ProductController;
import repository.BuyerRepository;
import repository.OrderRespository;
import repository.PincodeServiceabilityRepository;
import repository.ProductRepository;
import service.OrderService;
import service.PincodeServiceability;
import service.ProductService;
import service.impl.BuyerServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.PincodeServiceabilityServiceImpl;
import service.impl.ProductServiceImpl;

public class Main {
    public static void main(String[] args) {

        BuyerRepository buyerRepository = new BuyerRepository();
        BuyerServiceImpl buyerService = new BuyerServiceImpl(buyerRepository);
        BuyerController buyerController = new BuyerController(buyerService);

        buyerController.addBuyer("Smriti", "Kolkata", "sdf@abc.com", "123");
        buyerController.addBuyer("Souradeep", "Bengaluru", "sdf@abc.com", "567");
        buyerController.getBuyerList().stream().forEach(buyer -> System.out.println("Buyer: "+ buyer.getBuyerName()));

        PincodeServiceabilityRepository pincodeServiceabilityRepository = new PincodeServiceabilityRepository();
        PincodeServiceability pincodeServiceability = new PincodeServiceabilityServiceImpl(pincodeServiceabilityRepository);
        ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductServiceImpl(productRepository);
        ProductController productController = new ProductController(productService, pincodeServiceability);
        productController.addProduct("Phone", "Apple", 10, "90");
        productController.addProduct("Laptop", "HP", 10, "90");
        productController.addProduct("TV", "LG", 10, "100");

        productController.addPincodeServiceablity("Phone", "90", "123", PaymentMode.PREPAID);
        productController.addPincodeServiceablity("Laptop", "90", "567", PaymentMode.PREPAID);

        productController.getProductList().stream().forEach(product -> System.out.println("Product: "+ product.getName()+ " quantity: "+product.getQuantity()));


        OrderRespository orderRespository = new OrderRespository();
        OrderService orderService = new OrderServiceImpl(orderRespository, pincodeServiceability, buyerService, productService);
        OrderController orderController = new OrderController(orderService);

        orderController.createOrder("Phone", "Smriti", 5, PaymentMode.PREPAID);
        orderController.createOrder("Laptop", "Souradeep", 5, PaymentMode.PREPAID);

        orderController.getOrderList().stream().forEach(order -> System.out.println("Order: "+ order.getOrderId()
                + " for product: "+order.getProductName()+ " for user: "+ order.getUserName()+" for quantity: "
                + order.getQuantity()));

        orderController.createOrder("Phone", "Smriti", 15, PaymentMode.PREPAID);
        orderController.createOrder("Laptop", "Smriti", 5, PaymentMode.PREPAID);

        productController.getProductList().stream().forEach(product -> System.out.println("Product: "+ product.getName()+ " quantity: "+product.getQuantity()));




    }
}