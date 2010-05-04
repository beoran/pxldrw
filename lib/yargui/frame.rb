# To change this template, choose Tools | Templates
# and open the template in the editor.
require 'java'


module Yargui
  class Frame < javax.swing.JFrame
    def initialize(w = 640, h= 480, name="Yargui")
      super(name)
      self.setSize(w, h)
    end

    # Adds a child component to this comonent's content pane
    def <<(child)
      self.getContentPane().add(child)
    end
  end

end
      
