# To change this template, choose Tools | Templates
# and open the template in the editor.
require 'java'


module Yargui
  class Frame < javax.swing.JFrame
    def initialize(name="Yargui", w = nil, h= nil)
      super(name)
      h ||= w
      self.setSize(w, h) if w 
    end

    # Adds a child component to this comonent's content pane
    def <<(child)
      self.getContentPane().add(child)
    end

    def menubar=(bar)
      @menubar = bar
      self.setJMenuBar(@menubar.swing)
      return @menubar
    end

    def add_menubar(target)
      bar = Slide::Menubar.new(target)
      self.menubar = bar
    end

    def add_menu(title)
      return nil unless self
      return self.menu(title)
    end

  end

end
      
