# To change this template, choose Tools | Templates
# and open the template in the editor.



require 'java'
require 'yargui'
require 'grid'
require 'color'

def handler(b, x, y, gr, gred)
  color = ::Color.new(255, 255, 255, 255, :white)
  gr.put(x / 10, y / 10, color)
  # gred.update_drawing
  gred.repaint
end

grid      = Grid.new(64, 64)
grid.fill(::Color.new(0,0,0,255,:black))
gridedit  = Yargui::Gridedit.new(grid)


frame     = Yargui::Frame.new("pxldrw", 210, 230)
  
# javax.swing.JFrame.new("Window") # Creating a Java JFrame
label = javax.swing.JLabel.new("Hello")
button = javax.swing.JButton.new "Press me!"
button.add_action_listener {|event| event.source.text = "You did it!"}


# We can transparently call Java methods on Java objects, just as if they were defined in Ruby.
# frame << (label)  # Invoking the Java method 'getContentPane'.
# frame << (button)  # Invoking the Java method 'getContentPane'.
=begin
gridedit.mouse.press do |b, x, y|
  handler(b, x, y, grid, gridedit)
end

gridedit.mouse.drag do |b, x, y|
  handler(b, x, y, grid, gridedit)
end
=end

frame.setLayout(java.awt.BorderLayout.new());
frame << gridedit
# frame.setSize(gridedit.wide, gridedit.high)
frame.setDefaultCloseOperation(javax.swing.JFrame::EXIT_ON_CLOSE)

# frame.pack
frame.setVisible(true)

puts "Hello World"
