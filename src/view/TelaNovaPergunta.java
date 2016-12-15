package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import model.tiposDisciplina;

public class TelaNovaPergunta extends JFrame {

	private static final long serialVersionUID = 3062747303017339070L;
	private JPanel contentPane;
	private JTextField TituloPergunta;
	private JTextArea DescricaoPergunta;
	private JScrollPane scrollPanel;
	private JComboBox<tiposDisciplina> disciplinaPergunta;
	private JButton btnEnviar;

	public TelaNovaPergunta() {
		initComponents();
	}

	private void initComponents() {
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Criar Nova Pergunta");
		setBounds(100, 100, 394, 287);
		setResizable(false);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		disciplinaPergunta = new JComboBox<tiposDisciplina>();
		disciplinaPergunta.setBounds(55, 32, 180, 20);
		contentPane.add(disciplinaPergunta);
		
		JLabel lblDisciplina = new JLabel("Disciplina: ");
		lblDisciplina.setBounds(10, 35, 80, 14);
		contentPane.add(lblDisciplina);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 60, 46, 14);
		contentPane.add(lblTitulo);
		
		TituloPergunta = new JTextField();
		TituloPergunta.setBounds(10, 85, 355, 20);
		contentPane.add(TituloPergunta);
		TituloPergunta.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 115, 46, 14);
		contentPane.add(lblDescrio);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setName("btnEnviar");
		btnEnviar.setBounds(276, 215, 89, 23);
		contentPane.add(btnEnviar);
		
		DescricaoPergunta = new JTextArea();
        DescricaoPergunta.setLineWrap(true);
        DescricaoPergunta.setWrapStyleWord(true);
		scrollPanel = new JScrollPane();
		scrollPanel.setViewportView(DescricaoPergunta);
		scrollPanel.setBounds(10, 133, 355, 71);
		
		contentPane.add(scrollPanel);
		
		JLabel lblCriarNovaPergunta = new JLabel("Criar Nova Pergunta");
		lblCriarNovaPergunta.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCriarNovaPergunta.setBounds(10, 1, 249, 23);
		contentPane.add(lblCriarNovaPergunta);
	}

	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	public tiposDisciplina getDisciplinaPergunta() {
		return disciplinaPergunta.getItemAt(disciplinaPergunta.getSelectedIndex());
	}

	public String getTituloPergunta() {
		return TituloPergunta.getText();
	}

	public String getDescricaoPergunta() {
		return DescricaoPergunta.getText();
	}

	public void setOpcaoDisciplina(tiposDisciplina disciplinaPergunta) {
		this.disciplinaPergunta.addItem(disciplinaPergunta);
	}

	public void addPerguntaListener(ActionListener perguntaListener) {
		btnEnviar.addActionListener(perguntaListener);		
	}
}