# To change this template, choose Tools | Templates
# and open the template in the editor.



require 'java'
require 'yargui'
require 'grid'
require 'color'
grid      = Grid.new(20, 20)
gridedit  = Yargui::Gridedit.new(grid)


frame     = Yargui::Frame.new("pxldrw", 210, 230)
  
# javax.swing.JFrame.new("Window") # Creating a Java JFrame
label = javax.swing.JLabel.new("Hello")
button = javax.swing.JButton.new "Press me!"
button.add_action_listener {|event| event.source.text = "You did it!"}


# We can transparently call Java methods on Java objects, just as if they were defined in Ruby.
# frame << (label)  # Invoking the Java method 'getContentPane'.
# frame << (button)  # Invoking the Java method 'getContentPane'.
gridedit.mouse_handler.click do |b, x, y|
  puts "Click!", b, x, y
  color = ::Color.new(255, 255, 255, 255, :white)
  grid.put(x / 10, y / 10, color)
  p grid
  gridedit.repaint
end

frame.setLayout(java.awt.BorderLayout.new());
frame << gridedit
# frame.setSize(gridedit.wide, gridedit.high)
frame.setDefaultCloseOperation(javax.swing.JFrame::EXIT_ON_CLOSE)

# frame.pack
frame.setVisible(true)

puts "Hello World"
