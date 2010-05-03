# To change this template, choose Tools | Templates
# and open the template in the editor.



require 'java'
require 'yargui'
require 'grid'
grid      = Grid.new(20, 20)
gridedit  = Yargui::GridEdit.new(grid)


frame =  Yargui::Frame.new()
  
# javax.swing.JFrame.new("Window") # Creating a Java JFrame
label = javax.swing.JLabel.new("Hello")
button = javax.swing.JButton.new "Press me!"
button.add_action_listener {|event| event.source.text = "You did it!"}


# We can transparently call Java methods on Java objects, just as if they were defined in Ruby.
# frame << (label)  # Invoking the Java method 'getContentPane'.
# frame << (button)  # Invoking the Java method 'getContentPane'.


frame.setLayout(java.awt.BorderLayout.new());
frame << gridedit
frame.setSize(gridedit.wide, gridedit.high)
frame.setDefaultCloseOperation(javax.swing.JFrame::EXIT_ON_CLOSE)

# frame.pack
frame.setVisible(true)

puts "Hello World"
