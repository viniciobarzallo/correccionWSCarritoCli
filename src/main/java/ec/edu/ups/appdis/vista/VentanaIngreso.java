package ec.edu.ups.appdis.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import ec.edu.ups.appdis.modelo.Detalles;
import ec.edu.ups.appdis.modelo.Parametros;
import ec.edu.ups.appdis.modelo.Producto;
import ec.edu.ups.appdis.modelo.Respuesta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaIngreso extends JFrame {

    private String WS_GET_PRODUCTO = "http://localhost:8080/correccionWSCarrito/ws/carrito/producto";
    private String WS_SAVE_GUARDAR = "http://localhost:8080/correccionWSCarrito/ws/carrito/factura";
    private List<Detalles> listDetalles = new ArrayList<Detalles>();
    private JPanel contentPane;
    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtCorreo;
    private JTextField txtProductoId;
    private JTextField txtNombreProducto;
    private JTextField txtPrecio;
    private JTextField txtCantidad;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaIngreso frame = new VentanaIngreso();
                    frame.setTitle("Cliente REST");

                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VentanaIngreso() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 608, 336);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Cedula:");
        lblNewLabel.setBounds(16, 46, 61, 16);
        contentPane.add(lblNewLabel);

        txtCedula = new JTextField();
        txtCedula.setBounds(111, 41, 130, 26);
        contentPane.add(txtCedula);
        txtCedula.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Nombre:");
        lblNewLabel_1.setBounds(16, 84, 61, 16);
        contentPane.add(lblNewLabel_1);

        txtNombre = new JTextField();
        txtNombre.setBounds(111, 79, 130, 26);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Correo:");
        lblNewLabel_2.setBounds(300, 46, 61, 16);
        contentPane.add(lblNewLabel_2);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(400, 41, 180, 26);
        contentPane.add(txtCorreo);
        txtCorreo.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Cod. producto:");
        lblNewLabel_3.setBounds(66, 140, 95, 16);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Descripcion:");
        lblNewLabel_4.setBounds(16, 194, 95, 16);
        contentPane.add(lblNewLabel_4);

        txtProductoId = new JTextField();
        txtProductoId.setBounds(161, 135, 130, 26);
        contentPane.add(txtProductoId);
        txtProductoId.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Producto producto = new Producto();

                    producto.setCodigoProducto(Integer.valueOf(txtProductoId.getText()));

                    buscarProducto(Integer.valueOf(txtProductoId.getText()));

                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, "Producto no existe");
                }

            }
        });
        btnBuscar.setBounds(305, 134, 117, 29);
        contentPane.add(btnBuscar);

        txtNombreProducto = new JTextField();
        txtNombreProducto.setBounds(111, 190, 130, 26);
        contentPane.add(txtNombreProducto);
        txtNombreProducto.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Precio:");
        lblNewLabel_5.setBounds(255, 195, 61, 16);
        contentPane.add(lblNewLabel_5);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(302, 190, 67, 26);
        contentPane.add(txtPrecio);
        txtPrecio.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Cantidad:");
        lblNewLabel_6.setBounds(381, 195, 61, 16);
        contentPane.add(lblNewLabel_6);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(442, 190, 67, 26);
        contentPane.add(txtCantidad);
        txtCantidad.setColumns(10);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Parametros p = new Parametros();
                p.setCedula(txtCedula.getText());
                p.setNombre(txtNombre.getText());
                p.setCorreo(txtCorreo.getText());
                p.setListaDetalles(listDetalles);

                Client client = ClientBuilder.newClient();
                WebTarget target = client.target(WS_SAVE_GUARDAR);
                Respuesta respuesta = target.request().post(Entity.json(p), Respuesta.class);
                System.out.println(respuesta);
                JOptionPane.showMessageDialog(null, respuesta.getMensaje());
            }
        });
        btnGuardar.setBounds(240, 257, 117, 29);
        contentPane.add(btnGuardar);

        JButton btnNewButton = new JButton("Agregar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lista();
            }
        });
        btnNewButton.setBounds(430, 134, 117, 29);
        contentPane.add(btnNewButton);
    }

    protected Producto buscarProducto(int id) {
        // TODO Auto-generated method stub
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(
                WS_GET_PRODUCTO).queryParam("id", id);

        Producto producto = target.request().get(Producto.class);

        client.close();
        txtNombreProducto.setText(producto.getNombreProducto());
        txtPrecio.setText(String.valueOf(producto.getPrecio()));

        System.out.println("Nombre producto: " + producto.getCodigoProducto() + "" + producto.getNombreProducto());

        return producto;
    }

    public void lista() {
        Detalles d = new Detalles();
        d.setCodigoProducto(Integer.valueOf(txtProductoId.getText()));
        d.setCantidad(Integer.valueOf(txtCantidad.getText()));
        System.out.println("detalles " + d.getCantidad());
        listDetalles.add(d);

        txtNombreProducto.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
    }

}
