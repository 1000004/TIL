public class AutoCompletedJPanel extends JPanel{
     private JComboBox cb;
     private JTextField tf;
     private Vector<String>bookNames;
     private DefaultComboBoxModel model;
     private Vector<String>vec;

     public AutoCompleted(){
          bookNames = new Vector<>();
          vec = new Vector<String>();
          model = new DefaultComboBoxModel<>(vec);
          cb = new JComboBox(model);
          cb.setEditable(true);
          cb.setUI(new BasicCimboBoxUI(){
               @Override
               protected JButton createArrowButton(){
                    return new JButton(){
                         @Override
                         public int getWidth(){
                              return 0;
                         }         
                    };
               }     
          });     
          tf = (JTextField)(cb.getEditor().getEditorComponent());
          tf.setBorder(new LineBorder(Color.GRAY, 1));
          tf.getDocument().addDocumentListener(new DocumentListener(){
               @Override
               public void removeUpdate(DocumentEvent e){                
               }
               @Override
               public void insertUpdate(DocumentEvent e){
                    checkLength();
               }
               @Override
               public void changedUpdate(DocumentEvent e){
                    checkLength();
               }
          });
          add(cb);
     }
     public JTextField getTf(){
          return tf;
     }
     public void removeAll(){
          bookNames.removeAllElements();
     }
     public void addBookNames(String name){
          for(int idx = 0; idx < bookNames.size(); idx++){
               if(bookNames.get(idx).equals(name)){
                    bookNames.remove(idx);
               }
          }
     }
     public void clear(){
          tf.setText(null);
     }
     private void checkLength(){
         String input = tf.getText();
          cb.hidePopup();
          if(input.length() >= 1) {
               vec.clear();
               for(String temp : bookNames){
                    if(temp.startWith(input)){                    
                         vec.add(temp);
                    }
               }
               if(vec.size() > 0){
                    cb.showPopup();
               }
          }
     }
     public String result(){
          return tf.getText();
     }
}
