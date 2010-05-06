# To change this template, choose Tools | Templates
# and open the template in the editor.

require 'palette'

describe Palette do
  before(:each) do
    @palette = Palette.new
    @color   = Color.new(10,20,30)
  end

  it "should be emptu after construction" do
    @palette.size.should == 0
  end

  it "should allow colors to be added and gotten back" do
    @palette.add(@color)
    @palette.size.should == 1
    @palette.get(0).should == @color
  end
end

