package view;

import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import model.tiposDisciplina;

public class TelaPergunta extends JFrame {
	
	private static final long serialVersionUID = -4365136588834833433L;
	
	private JButton btnEnviar;
	private JButton btnCancelar;
	private JButton btnChangeDscpln;
    private JComboBox<tiposDisciplina> selectDisciplina;
    private JLabel lblTitulo;
    private JLabel lblDescricao;
    private JScrollPane scrollPanel;
    private JTextArea areaResposta;
	
    public TelaPergunta() {
    	initComponents();
	}
    
	private void initComponents() {

		btnEnviar = new JButton();
		btnCancelar = new JButton();
		btnChangeDscpln = new JButton();
		selectDisciplina = new JComboBox<tiposDisciplina>();
        lblTitulo = new JLabel();
        lblDescricao = new JLabel();
        scrollPanel = new JScrollPane();
        areaResposta = new JTextArea();
        
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setText("Título");

        lblDescricao.setText("Descrição Pergunta");

        areaResposta.setColumns(20);
        areaResposta.setLineWrap(true);
        areaResposta.setRows(5);
        areaResposta.setToolTipText("Resposta");
        scrollPanel.setViewportView(areaResposta);

        btnChangeDscpln.setText("Mudar");
        btnChangeDscpln.setName("btnChngDscpln");
        btnCancelar.setText("Cancelar");
        btnCancelar.setName("btnCancelar");
        btnEnviar.setText("Enviar");
        btnEnviar.setName("btnEnviar");
        
        selectDisciplina = new JComboBox<tiposDisciplina>();
        selectDisciplina.setEnabled(false);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanel, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(selectDisciplina, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(btnChangeDscpln)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelar)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEnviar))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(lblDescricao)
                                .addComponent(lblTitulo))
                            .addGap(247, 247, 247))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblDescricao)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(scrollPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(selectDisciplina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar)
                    .addComponent(btnChangeDscpln))
                .addGap(20, 20, 20))
        );

        pack();
    }

	public void addPerguntaListener(ActionListener perguntaListener) {
		btnEnviar.addActionListener(perguntaListener);
		btnCancelar.addActionListener(perguntaListener);
		btnChangeDscpln.addActionListener(perguntaListener);
	}
	
	public tiposDisciplina getDisciplina() {
		return (tiposDisciplina) this.selectDisciplina.getSelectedItem();
	}

	public void setDisciplina(tiposDisciplina disciplina) {
		this.selectDisciplina.setSelectedItem(disciplina);
	}
	
	public void setOpcaoDisciplina(tiposDisciplina disciplinaPergunta) {
		this.selectDisciplina.addItem(disciplinaPergunta);
	}

	public String getAreaResposta() {
		return areaResposta.getText();
	}

	public void setLblTitulo(String lblTitulo) {
		this.lblTitulo.setText(lblTitulo);
	}

	public void setLblDescricao(String lblDescricao) {
		this.lblDescricao.setText(lblDescricao);
	}

	public void enableChangeDisciplina() {
		this.selectDisciplina.setEnabled(true);
	}

	public void disableChangeDisciplina() {
		this.selectDisciplina.setEnabled(false);
	}
	
	public void showChngDscpln() {
		btnChangeDscpln.setVisible(true);
	}
	
	public void hideChngDscpln() {
		btnChangeDscpln.setVisible(false);
	}
}
